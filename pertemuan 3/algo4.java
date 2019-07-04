import java.util.Scanner;

public class algo4{
	public static void main(String[] args) {
		
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.print("Masukkan bilangan pertama : ");
		a = sc.nextInt();
		System.out.print("Masukkan bilangan kedua : ");
		b = sc.nextInt();

		if (a==b) {
			System.out.println("Bilangan pertama dan kedua sama besar");
		}else if(a<b){
			System.out.println("Bilangan pertama lebih kecil dari bilangan kedua");
		}else{
			System.out.println("Bilangan pertama lebih besar dari bilangan kedua");
		}
	}
}