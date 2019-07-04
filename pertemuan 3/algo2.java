import java.util.Scanner;

public class algo2{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Masukkan bilangan : ");
		int bil = sc.nextInt();

		int hasil = bil % 2 ;
		if (hasil==0) {
			System.out.println("Bilangan "+bil+" Termasuk Bilangan Genap");
		}else if (hasil==1){
			System.out.println("Bilangan "+bil+" Termasuk Bilangan Ganjil");
		}
	}
}