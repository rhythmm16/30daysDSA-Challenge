import java.util.*;

class TaskManager {
    private static class Task {
        int userId, taskId, priority;
        Task(int u, int t, int p) {
            userId = u; taskId = t; priority = p;
        }
    }

    private Map<Integer, Task> taskMap;  // taskId -> Task
    private PriorityQueue<Task> pq;      // max-heap by priority, then taskId

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });
        for (List<Integer> t : tasks) {
            int u = t.get(0), tid = t.get(1), p = t.get(2);
            Task task = new Task(u, tid, p);
            taskMap.put(tid, task);
            pq.offer(task);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        pq.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task updated = new Task(taskMap.get(taskId).userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        pq.offer(updated); // push new version; stale one will be skipped
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); // stale entry remains in heap, cleaned later
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            Task curr = taskMap.get(top.taskId);
            if (curr != null && curr.priority == top.priority) {
                taskMap.remove(top.taskId); // execute & remove
                return top.userId;
            }
        }
        return -1;
    }
}
