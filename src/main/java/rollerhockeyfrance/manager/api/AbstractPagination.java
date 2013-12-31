package rollerhockeyfrance.manager.api;

import java.util.Collection;

import lombok.Data;

@Data
public abstract class AbstractPagination<T> {
	
	private Collection<T> data;

	private Long total;
	
}
