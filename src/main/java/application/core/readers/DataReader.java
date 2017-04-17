package application.core.readers;

import java.util.List;

public interface DataReader<T,R> {

	List<R> reader(T source);
}
