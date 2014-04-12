#include <stdio.h>
#include <stdlib.h>
 
int main(int argc, char* argv) {
   FILE * fp;
   int i = 0;
   fp = fopen ("numbers", "w+");
   for(i = 1;i<=100000000;i++) {
     fprintf(fp, "%d\n", i);
   }
   fclose(fp);
   return(0);
}
