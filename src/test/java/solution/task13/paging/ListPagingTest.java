package solution.task13.paging;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ListPagingTest {
    @Test
    void shouldReturnValidNextPage(){
        List<String> list = List.of("A", "B", "C", "D" ,"E", "F", "G");
        Paging<String> paging = new ListPaging<>(list, 2);
        assertEquals(4, paging.size());
        assertEquals(List.of("A", "B"), paging.current().collect(Collectors.toList()));
        assertEquals(List.of("C", "D"), paging.next().collect(Collectors.toList()));
        assertEquals(List.of("E", "F"), paging.next().collect(Collectors.toList()));
        assertEquals(List.of("G"), paging.next().collect(Collectors.toList()));
        assertEquals(List.of("G"), paging.next().collect(Collectors.toList()));
    }

    @Test
    void shouldReturnValidPreviousPage(){
        List<String> list = List.of("A", "B", "C", "D" ,"E", "F", "G");
        Paging<String> paging = new ListPaging<>(list, 2);
        assertEquals(4, paging.size());
        paging.skip(paging.size() - 1);
        assertEquals(List.of("G"), paging.current().collect(Collectors.toList()));
        assertEquals(List.of("E", "F"), paging.previous().collect(Collectors.toList()));
        assertEquals(List.of("C", "D"), paging.previous().collect(Collectors.toList()));
        assertEquals(List.of("A", "B"), paging.previous().collect(Collectors.toList()));
        assertEquals(List.of("A", "B"), paging.previous().collect(Collectors.toList()));
    }
}