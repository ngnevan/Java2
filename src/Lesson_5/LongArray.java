package Lesson_5;

public class LongArray {
    static final int size = 10000000;
    static final int h = size / 2;
    static final int numThreads = 4;

    public void oneThread() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы oneThread в мс: " + (System.currentTimeMillis() - a));
    }

    public void multipleThreads() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        float[][] an = new float[numThreads][];
        for (int i = 0; i < numThreads; i++) {
            an[i] = new float[size/numThreads];
        }

        for (int i = 0; i < numThreads; i++) {
            System.arraycopy(arr, i*size/numThreads, an[i], 0, size/numThreads);
        }

        Thread[] tn = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            tn[i] = new Thread(new myRunnableClass(an[i], size/numThreads, i*size/numThreads));
            tn[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                tn[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < numThreads; i++) {
            System.arraycopy(an[i], 0, arr, i*size/numThreads, size/numThreads);
        }

        System.out.println("Время работы multipleThreads в мс: " + (System.currentTimeMillis() - a));

    }

    class myRunnableClass implements Runnable {
        int shift;
        int size;
        float[] an;

        public myRunnableClass(float[] an, int size, int shift) {
            this.shift = shift;
            this.size = size;
            this.an = an;
        }

        @Override
        public void run() {
            for (int i = 0; i < size; i++) {
                an[i] = (float)(an[i] * Math.sin(0.2f + (i + shift) / 5) * Math.cos(0.2f + (i + shift) / 5) * Math.cos(0.4f + (i + shift) / 2));
            }
        }
    }

}

class LongArrayMain {
    public static void main(String[] args) {
        LongArray la = new LongArray();
        la.oneThread();
        la.multipleThreads();
    }
}