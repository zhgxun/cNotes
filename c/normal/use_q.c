#include <stdio.h>
#include "queue.h"

/**
 * 模拟队列
 */
int main(int argc, char const *argv[])
{
	// 队列结构体
	Queue line;
	// 整数别名
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
					printf("Putting %d into queue.\n", temp);
					EnQueue(temp, &line);
				}
				break;
			case 'd':
				// 此时temp还保留着上一次最新添加的值，如果有的话
				if (QueueIsEmpty(&line)) {
					puts("Nothing to delete.");
				} else {
					DeQueue(&temp, &line);
					printf("Removing %d from queue.\n", temp);
				}
				break;
		}

		printf("%d items in queue\n", QueueItemCount(&line));
		puts("Type a to add, d to delete, q to quit:");
	}

	EmptyTheQueue(&line);

	puts("Bye.");

	return 0;
}
