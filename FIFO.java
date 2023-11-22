import java.util.Scanner;
public class FIFO{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of frames:");
		int frames=sc.nextInt();
		System.out.println("Enter no. of inputstream:");
		int inputstream[]=new int[sc.nextInt()];
		for(int i=0;i<inputstream.length;i++){
			 inputstream[i]=sc.nextInt();
		}
	simulatepagereplacement(inputstream,frames);
	}
	public static void simulatepagereplacement(int inputstream[],int frames){
		int pageFaults=0;
		int pageHits=0;
		int temp[]=new int[frames];
		for (int i = 0; i < frames; i++) {
			temp[i]	= -1;
		}
		for(int i=0;i<inputstream.length;i++){
			int s=0;
			for(int j=0;j<frames;j++){
				if(inputstream[i]==temp[j]){
					pageHits=1;
					pageFaults--;
					break;
				}
			}
			pageFaults++;
			if(pageFaults <=frames && s==0){
				temp[i]=inputstream[i];
			}
			else if(s==0){
				temp[(pageFaults - 1) % frames]=inputstream[i];
			}
			System.out.println("Incoming | frame1 | frame2 | fream3 | pageFault | pagehit");
			System.out.println(" |---|---|---|---|---|---|");
			System.out.print("| " + inputstream[i] + " ||..");
			for(int j=0;j<frames;j++){
				if(temp[j]!=-1){
					System.out.print(" " + temp[j] + " ");
				}
				else{
					System.out.print(" - |");
				}
			}
			System.out.print(" " + pageFaults + " ");
			System.out.print(" " + pageHits + " ");
			System.out.println();
		}
		System.out.println("Total pagefault: " + pageFaults);
		System.out.println("Total pagehits: " + pageHits);
	}
}
	