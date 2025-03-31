lab3: createThreads.o testCT.o sequential.o testS.o parallel1.o testP.o
	gcc -o lab3CT createThreads.o testCT.o
	gcc -o lab3S sequential.o testS.o
	gcc -o lab3P parallel1.o testP.o

createThreads.o: createThreads.c createThreads.h
	gcc -o createThreads.c

testCT.o: testCT.c
	gcc -o testCT.c

sequential.o: sequential.c sequential.h
	gcc -o sequential.c

testS.o: testS.c
	gcc -o testS.c

parallel1.o: parallel1.c parallel1.h
	gcc -o parallel1.c

testP.o: testP.c
	gcc -o testP.c
