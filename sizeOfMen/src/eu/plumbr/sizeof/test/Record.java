package eu.plumbr.sizeof.test;

/**
 * 记录对象
 * 
 * @author Ace
 * 
 */
public class Record {

	/** 记录内容 */
	private String value;

	public Record() {
		this.value = "";
	}

	public Record(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
