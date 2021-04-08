public static void reverseString(String str)
{
	if(str.length() > 0)
	{
		char ch = str.charAt(0);
		reverseString(str.substring(1));
		System.out.print(ch);
	}
}

public static int factorialATZERET ( int n )
{
	if(n==1)
		return 1;
	else 
		return(factorial(n-1)*n);
}

public static int Multiply2Nums(int a, int  b)
{	
	if(b==0)
		return(0);	
	if(b%2==0)
		return(a22(a+a,b/2));
	return(a22(a+a,b/2)+a);
}

מדפיס 12321 
public static void Series3(int N,int places)
{		
	if(N>=places)
	{
		System.out.print(N +" ");
	}
	else
	{
		System.out.print(N+ " ");
		Series3(N+1,places);
		System.out.print(N+ " ");
		
	}
	
}

פיבונצי (1,1)
מחזיר את הערך של הפיבונצי במיקום של אן כשהוא מתחיל ב0
public static int Fibonachi(int n)
{
	if(n==1)
		return 0;
	else if(n==2)
		return 1;
	else
		return (f(n-1)+f(n-2));
}

מחזיר את הערך של הספרה הגדולה במספר
public static int r(int number, int max)
{
	if(number==0)
		return(max);
	else
	{
		if(max<number%10)
			max=number%10;
		return(r(number/10, max));
	}
	
}

בדיקה האם הסדרה היא חשבונית
public static boolean isArithmeticSequence(int[] arr)
{
	return isArithmeticSequence(arr, arr.length-1);
}

private static boolean isArithmeticSequence(int[] arr, int k)
{
	if (k <= 1)
		return true;
	if ((arr[k]-arr[k-1]) != (arr[k-1]-arr[k-2]))
		return false;
	return isArithmeticSequence(arr, k-1);
}

חיבור כל אברי המערך		
public static int a1(int a[], int n) {
	if (n == 1)
		return (a[0]);
	return a[n - 1] + a1(a, n - 1);
}

האם הסדרה עולה?
public static boolean a2(int a[], int n) {
	if (n == 1)
		return true;
	else if (a[n - 1] > a[n - 2] && a2(a, n - 1))
		return true;
	return false;
}

האם המספר פולינדרומי(1765671)?
public static boolean a3(int a[], int b, int e) {
	if (e == 1)
		return true;

	if (e == (int) (a.length / 2)) {
		if (a.length % 2 == 0) {
			if (a[e] == a[e - 1])
				return true;
		}
		return true;
	} else if (a[b] == a[e - 1] && a3(a, b + 1, e - 1))
		return true;
	return false;
}

חישוב ממוצע של ספרות המספר
public static double digitsAverage(int n)
{
	return digitsAverage(n,numDigits(n));
}
(הממוצע שלי עם כל היתר)
private static double digitsAverage(int a, int k)
{	
	if(a < 10)
		return (a);
	return (((a%10)+(digitsAverage(a/10,k-1))*(k-1))/k);
} 
(כמה ספרות יש)
public static int numDigits(int num)
{	
	if(num < 10)
		return (1);
	return (1 + numDigits(num/10));
}

public static int MaxInAnArray(int[] a, int p)
{
	if(p==0)
		return(a[p]);

	else
	{	int temp= max(a, p-1);
		if(temp<a[p])
			return a[p];
		else
			return temp;
	}
}

מיון מערך בצורה רקורסיבית
public static void sort(int[] array, int start, int end)
{
	if (start < end)
	{
		sort(array, start+1, end);
		if(array[start]<=array[end])
		{
			sort(array, start, end-1);
		}
		else if(array[start]>array[end])
		{
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			sort(array, start, end-1);
		}
	}
	else if(start == end)
	return;
}