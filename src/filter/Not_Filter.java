package filter;

public class Not_Filter {

	public void  not(Filter a) {
		a.setFlag(false);
		a.filter();
		
	}
	
}
