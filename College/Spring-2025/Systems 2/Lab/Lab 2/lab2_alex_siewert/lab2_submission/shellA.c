#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define MAXLINE 80 /* 80 chars per line, per command, should be enough. */

/** The setup() routine reads in the next command line string storing it in the input buffer.
The line is separated into distinct tokens using whitespace as delimiters.  Setup also 
modifies the args parameter so that it holds points to the null-terminated strings which 
are the tokens in the most recent user command line as well as a NULL pointer, indicating the
end of the argument list, which comes after the string pointers that have been assigned to
args. ***/

void setup(char iBuffer[], char *args[],int *bgrnd)
{
    int length,  /* #  characters in the command line */
        i,       /* Index for iBuffer arrray          */
        start,   /* Beginning of next command parameter           */
        j;       /* Where to place the next parameter into args[] */

    /* Read what the user enters */
    length = read(STDIN_FILENO, iBuffer, MAXLINE);  

    j = 0;
    start = -1;

    if (length == 0)
        exit(0);            /* Cntrl-d was entered, end of user command stream */

    if (length < 0){
        perror("error reading command");
	exit(-1);           /* Terminate with error code of -1 */
    }
    
    /* Examine every character in the input buffer */
    for (i = 0; i < length; i++) {
 
        switch (iBuffer[i]){
        case ' ':
        case '\t' :          /* Argument separators */

            if(start != -1){
                args[j] = &iBuffer[start];    /* Set up pointer */
                j++;
            }

            iBuffer[i] = '\0'; /* Add a null char; make a C string */
            start = -1;
            break;

        case '\n':             /* Final char examined */
            if (start != -1){
                args[j] = &iBuffer[start];     
                j++;
            }

            iBuffer[i] = '\0';
            args[j] = NULL; /* No more arguments to this command */
            break;

        case '&':
            *bgrnd = 1;
            iBuffer[i] = '\0';
            break;
            
        default :             /* Some other character */
            if (start == -1)
                start = i;
	}
 
    }    
    args[j] = NULL; /* Just in case the input line was > 80 */
} 

int main(void)
{
    char iBuffer[MAXLINE]; /* Buffer to hold the command entered */
    char *args[MAXLINE/2+1];/* Command line (of 80) has max of 40 arguments */
    int bgrnd;             /* Equals 1 if a command is followed by '&', else 0 */
    

    /* Program terminates normally inside setup */
    while (1)
    {            

	    bgrnd = 0;

	    printf("Sys2Sh: ");  /* Shell prompt */
        fflush(0);

        setup(iBuffer, args, &bgrnd);       /* Get next command */
        printf("%s %s\n", iBuffer, *args);

        pid_t pid = fork();

        if (pid == -1)
        {
            perror("fork fail\n");
        }

        // child
        if (pid == 0)
        {   
            // execvp only returns on failure otherwise child process is just replaced
            if(execvp(args[0], args) == -1)
            {
                perror("erroneous command\n");
            }
            exit(1);
        }

        // parent
        else
        {
            int status;
            if (bgrnd == 0)
            {   
                waitpid(pid, &status, 0);
            }
            printf("exited with status: %d\n", WEXITSTATUS(status));
        }
    }
}
