package eu.plumbr.sizeof.test;

/**
 * ��¼����
 * 
 * @author Ace
 * 
 */
public class Record {

	/** ��¼���� */
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
