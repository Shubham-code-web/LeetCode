class MedianFinder {

    // Max heap: stores the smaller half of the numbers
    PriorityQueue<Integer> fh;

    // Min heap: stores the larger half of the numbers
    PriorityQueue<Integer> sh;

    public MedianFinder() {
        // Max heap
        fh = new PriorityQueue<>((a, b) -> b - a);

        // Min heap
        sh = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // First element
        if (fh.isEmpty()) {
            fh.offer(num);
        }

        // Only one element currently exists
        else if (sh.isEmpty()) {

            // New number belongs to the second half
            if (num > fh.peek()) {
                sh.offer(num);
            } 
            // New number belongs to the first half
            else {
                sh.offer(fh.poll());
                fh.offer(num);
            }
        }

        else {

            // num belongs to the smaller half
            if (num < fh.peek()) {
                fh.offer(num);

                // Keep fh at most one element larger than sh
                if (fh.size() > sh.size() + 1) {
                    int temp = fh.poll();
                    sh.offer(temp);
                }
            }

            // num belongs to the larger half
            else if (num > sh.peek()) {
                sh.offer(num);

                // Balance the two heaps
                if (sh.size() > fh.size()) {
                    fh.offer(sh.poll());
                }
            }

            // num lies between the two halves
            else {

                // If fh has fewer elements, add to fh
                if (sh.size() < fh.size())
                    sh.offer(num);
                else
                    fh.offer(num);
            }
        }
    }

    public double findMedian() {

        int size1 = fh.size();
        int size2 = sh.size();

        // Odd number of elements
        // fh always contains the extra element
        if (size1 > size2)
            return fh.peek();

        // Even number of elements
        return (fh.peek() + sh.peek() * 1D) / 2.0;
    }
}