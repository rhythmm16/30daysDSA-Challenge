import java.util.*;

class Router {
    private int memoryLimit;
    private Deque<int[]> queue;  // store packets [src, dst, ts]
    private Set<String> seen;    // to detect duplicates

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.seen = new HashSet<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) {
            return false; // duplicate
        }
        
        // if memory full → evict oldest
        if (queue.size() == memoryLimit) {
            int[] old = queue.pollFirst();
            String oldKey = old[0] + "#" + old[1] + "#" + old[2];
            seen.remove(oldKey);
        }
        
        queue.offerLast(new int[]{source, destination, timestamp});
        seen.add(key);
        return true;
    }
    
    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];
        int[] packet = queue.pollFirst();
        String key = packet[0] + "#" + packet[1] + "#" + packet[2];
        seen.remove(key);
        return packet;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        int count = 0;
        for (int[] packet : queue) {
            if (packet[1] == destination && packet[2] >= startTime && packet[2] <= endTime) {
                count++;
            }
        }
        return count;
    }
}
