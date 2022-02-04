class Solution {
    
    
    public static class MonotonicQueue {
        LinkedList<Integer> q;

        public MonotonicQueue() {
            this.q = new LinkedList<>();
        }

        public void enqueue(int i) {
            while (!q.isEmpty() && q.peekLast() < i) {
                q.pollLast();
            }
            q.offerLast(i);
        }

        public int getMax() {
            return q.peekFirst();
        }

        public void delete(int i) {
            if (i == q.peekFirst()) {
                q.pollFirst();
            }
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        MonotonicQueue q = new MonotonicQueue();

        int[] res = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                q.enqueue(nums[i]);
            } else {
                q.enqueue(nums[i]);
                res[idx++] = q.getMax();
                // NOTE: here is not i - k, as the current getMax is complete,
                // this is for getting ready for next window, thus needs +1
                q.delete(nums[i - k + 1]);
            }
        }

        return res;
    }
    
    
    // Deque + 2 while loops
    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // monotonic queue, stores index
        // increasing, right the biggest, left the smallest
        // if out of boundary, poll()
        
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        Deque<Integer> q = new ArrayDeque<>();
        
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                // this one is not useful anymore
                q.pollLast();
            }
            
            // offer the current one enqueue
            q.offerLast(i);
            
            // remove the first one if it is out of boundary
            while (i - q.peekFirst() >= k) {
                q.pollFirst();
            }
            
            if (i < k - 1) continue;
            
            res[idx++] = nums[q.peekFirst()];
        }
        
        return res;
    }
    */
    
    
    
    
    
    
    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        int[] res = new int[n - k + 1];
        int idx = 0;
        
        // monotonic queue
        // contains optional candidates for the maximum number
        // -> candidate in increasing order
        // -1 1 3
        // monoq right side is First, left side is Last
        Deque<Integer> monoq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!monoq.isEmpty() && monoq.peekFirst() < i - k + 1) {
                monoq.pollFirst();
            }
            while (!monoq.isEmpty() && nums[monoq.peekLast()] < nums[i]) {
                monoq.pollLast();
            }
            
            monoq.offer(i);
            
            if (i >= k - 1) {
                res[idx++] = nums[monoq.peekFirst()];
            }
        }
        
        return res;
    }
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        if (k == 1) return nums;
        
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            
            if (i >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }
        
        return res;
    }
    */
}