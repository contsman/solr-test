import java.util.Scanner;

import org.junit.Test;

public class TestSuanFa {

	@Test
	public void testRabbit() {
		final int MONTH = 15;
		long f1 = 1L, f2 = 1L;
		long f;
		for (int i = 3; i < MONTH; i++) {
			f = f2;
			f2 = f1 + f2;
			f1 = f;
			System.out.print("第" + i + "个月的兔子对数: ");
			System.out.println(" " + f2);
		}
	}

	@Test
	public void testSuShu() {
		int count = 0;
		for (int i = 101; i < 200; i++) {
			boolean b = true;
			for (int j = i; j > 2; j--) {
				if (i % j == 0&&j!=i) {
					b = false;
					break;
				}
			}
			if (b) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println("\n素数的个数：" + count);
	}
	
	@Test
	public void testShuiXianHua() {
		int a,aa,aaa,num = 0;
		for (int i = 100; i < 999; i++) {
			aaa = i/100;
			aa = (i%100)/10;
			a = (i%100)%10;
			if((aaa*aaa*aaa+aa*aa*aa+a*a*a)==i){
				System.out.println(i);
				num++;
			}
		}
		System.out.println(num);
	}
	
	@Test
	public void testFenJieZhiYinShu() {
		int number = 0;
		Scanner scanner = new Scanner(System.in);
		number = scanner.nextInt();
		for(int i=2;i<number;i++){
			if(number%i==0){
				for(int j=2;j<i;j++){
					if(i%j!=0){
						System.out.println(i);
					}
				}
				
			}
		}
	}
	public void getBL(int width,int height){
		int[] aa = new int[]{2,3,5,7};
		
	}
}