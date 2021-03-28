package solution.task13.paging;
import java.util.List;
import java.util.stream.Stream;

public class ListPaging<T>  implements Paging<T>{
    private final List<T> list;
    private final int pageSize;
    private int currentPage = 0;

    public ListPaging(List<T> list, int pageSize) {
        this.list = list;
        this.pageSize = pageSize;
    }

    @Override
    public Stream<T> next() {
        if (isInvalidPage(currentPage + 1)){
            return Stream.empty();
        }
        currentPage++;
        return current();
    }

    @Override
    public Stream<T> previous() {
        if (isInvalidPage(currentPage - 1)){
            return Stream.empty();
        }
        currentPage--;
        return current();
    }

    @Override
    public Stream<T> skip(int i) {
        if (isInvalidPage(i - 1)){
            return Stream.empty();
        }
        currentPage = i - 1;
        return current();
    }

    @Override
    public Stream<T> current() {
        return list.stream().skip((long) currentPage * pageSize).limit(pageSize);
    }

    @Override
    public void reset() {
        currentPage = 0;
    }

    @Override
    public int size() {
        return list.size() % pageSize == 0 ? list.size() / pageSize : 1 + list.size() / pageSize;
    }

    @Override
    public int currentPageNumber() {
        return currentPage;
    }

    @Override
    public int pageSize() {
        return pageSize;
    }

    @Override
    public int itemsCount() {
        return list.size();
    }

    private boolean isInvalidPage(int page){
        return 0 > page || size() <= page;
    }
}
