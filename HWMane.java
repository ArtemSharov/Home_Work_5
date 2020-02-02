public class HWMane {
    public static void main(String[] args) {
        method_1();
        method_2();
    }
    public static void method_1(){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        long a = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            arr[i] = 1;
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Execution time method_1: " + (System.currentTimeMillis() - a) / 1000 + " seconds");
    }

    public static void method_2(){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < h; i++){
                    a1[i] = 1;
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
               }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    a2[i] = 1;
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        r1.run();
        r2.run();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Execution time method_2: " + (System.currentTimeMillis() - a) /1000 + " seconds");
    }
}
