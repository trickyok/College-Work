lab3: createThreads.o parallel1.o parallel2.o parallel3.o test.o
	gcc -o lab3-1 createThreads.o test.o
	gcc -o lab3-2 parallel1.o test.o
	gcc -o lab3-3 parallel2.o test.o
	gcc -o lab3-4 parallel3.o test.o

createThreads.o: createThreads.c
	gcc -c createThreads.c -o createThreads.o

parallel1.o: parallel1.c
	gcc -c parallel1.c -o parallel1.o

parallel2.o: parallel2.c
	gcc -c parallel2.c -o parallel2.o

parallel3.o: parallel3.c
	gcc -c parallel3.c -o parallel3.o

test.o: test.c
	gcc -c test.c -o test.o
