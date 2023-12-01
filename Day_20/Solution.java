class GfG
{
	public static int palinArray(int[] a, int n)
    {
        for (int num : a) {
            int original = num;
            int reversed = 0;
            int remainder;

            while (num > 0) {
                remainder = num % 10;
                reversed = reversed * 10 + remainder;
                num = num / 10;
            }

            if (original != reversed) {
                return 0; 
            }
        }
        return 1; 
    }
}