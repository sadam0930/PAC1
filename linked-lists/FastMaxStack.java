/**
* PAC 1
* Steven Adam
**/

public class FastMaxStack<T> implements MaxStack<T> {

	private final Maximizer<T> maximizer;
	private ListNode<T> top;
	private ListNode<T> maxSoFar;
	
	public FastMaxStack(Maximizer<T> maximizer) {
		this.maximizer = maximizer;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
    public void push(T value)
    {
        if (top == null) {
            top = new ListNode<T>(value, null);
            maxSoFar = top;
        } else {
            maxSoFar = maxSoFar.setValue(maximizer.getMax(value, top.value));
            top = top.setValue(value);
        }
    }

	@Override
	public T pop() {
		T value = top.value;
		top = top.next;
		maxSoFar = maxSoFar.next;
		return value;
	}

	@Override
	public T getMaxSoFar() {
		return maxSoFar.value;
	}

}
