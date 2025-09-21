import java.util.*;

class MovieRentingSystem {
    private static class MovieInfo {
        int shop, movie, price;
        MovieInfo(int s, int m, int p) { shop = s; movie = m; price = p; }
    }

    private Map<Integer, TreeSet<MovieInfo>> available;  // movie -> unrented copies
    private TreeSet<MovieInfo> rented;                   // all rented copies
    private Map<String, Integer> priceMap;               // (shop#movie) -> price

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>((a, b) -> 
            a.price != b.price ? a.price - b.price :
            a.shop != b.shop ? a.shop - b.shop :
            a.movie - b.movie
        );
        priceMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "#" + movie, price);
            available.computeIfAbsent(movie, k -> new TreeSet<>(
                (a, b) -> a.price != b.price ? a.price - b.price :
                         a.shop - b.shop
            )).add(new MovieInfo(shop, movie, price));
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        int k = 0;
        for (MovieInfo info : available.get(movie)) {
            res.add(info.shop);
            if (++k == 5) break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        MovieInfo info = new MovieInfo(shop, movie, price);
        available.get(movie).remove(info);
        rented.add(info);
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        MovieInfo info = new MovieInfo(shop, movie, price);
        rented.remove(info);
        available.get(movie).add(info);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int k = 0;
        for (MovieInfo info : rented) {
            res.add(Arrays.asList(info.shop, info.movie));
            if (++k == 5) break;
        }
        return res;
    }
}
