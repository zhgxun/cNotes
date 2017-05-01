#include <stdio.h>
#include "queue.h"

int main(int argc, char const *argv[])
{
	Queue line;
	Item temp;
	char ch;
	InitializeQueue(&line);
	puts("Testing the Queue interface. Type a to add a value, type d to delete a value, and type q to quit.");
	while ((ch = getchar()) != 'q') {
		if (ch != 'a' && ch != 'd') {
			continue;
		}

		switch (ch) {
			case 'a':
				printf("Integer to add: ");
				scanf("%d", &temp);
				if (QueueIsFull(&line)) {
					puts("Queue is full.");
				} else {
					printf("Putting %d into queue\n", temp);
					EnQueue(temp, &line);
				}
				break;
			case 'd':
				if (QueueIsEmpty(&line)) {
					puts("Nothing to delete.");
				} else {
					DeQueue(&temp, &line);
					printf("Removing %d from queue.\n", temp);
				}
				break;
			default:
				continue;
		}

		printf("%d items in queue\n", QueueItemCount(&line));
		puts("Type a to add, d to delete, q to quit:");
	}

	EmptyTheQueue(&line);

	puts("Bye.");

	return 0;
}
