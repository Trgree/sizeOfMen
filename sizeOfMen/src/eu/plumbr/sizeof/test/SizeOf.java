package eu.plumbr.sizeof.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import eu.plumbr.PersonDocument;
import eu.plumbr.sizeof.MemoryCounterAgent;
import gnu.trove.map.hash.TLongObjectHashMap;

public class SizeOf {
	static final int PERSONS = 10000;
	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NO = "123456789";
	private static Random rnd = new Random();

	public static void main(String[] args) {
		SizeOf s = new SizeOf();
		s.measure(s.getDocument());
		s.measure(s.getMap());
		s.measure(s.getTroveMap());
		s.measure(s.getNonRedundantTroveMap());
	}

	Map<Long, Person> getMap() {
		Map<Long, Person> persons = new HashMap<Long, Person>();
		for (int i = 0; i < PERSONS; i++) {
			Person p = randomPerson();
			persons.put(Long.valueOf(p.getId()), p);
		}
		return persons;
	}

	PersonDocument getDocument() {
		PersonDocument d = PersonDocument.Factory.newInstance();
		for (int i = 0; i < PERSONS; i++) {
			randomPersonDocument(d.addNewPerson());
		}
		return d;
	}
	
	TLongObjectHashMap<Person> getTroveMap() {
		TLongObjectHashMap<Person> map = new TLongObjectHashMap<Person>();
		for (int i = 0; i < PERSONS; i++) {
			Person p = randomPerson();
			map.put(Long.parseLong(p.getId()), p);
		}
		return map;
	}
	
	TLongObjectHashMap<NonRedundantPerson> getNonRedundantTroveMap() {
		TLongObjectHashMap<NonRedundantPerson> map = new TLongObjectHashMap<NonRedundantPerson>();
		for (int i = 0; i < PERSONS; i++) {
			NonRedundantPerson p = randomNonRedundantPerson();
			map.put(p.getId(), p);
		}
		return map;
	}	
	
	void measure(Object obj) {
		System.out.println(obj.getClass().getName() + ": shallow size="
				+ MemoryCounterAgent.sizeOf(obj) + " bytes, retained="
				+ MemoryCounterAgent.deepSizeOf(obj) + " bytes");
	}
	
	PersonDocument.Person randomPersonDocument(PersonDocument.Person p) {
		p.setId(randomId());
		p.setDateOfBirth(Calendar.getInstance());
		p.getDateOfBirth().setTimeInMillis(System.currentTimeMillis() - rnd.nextLong());
		p.setForename(randomString(8));
		p.setSurname(randomString(8));
		return p;
	}
	
	String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	String randomId() {
		StringBuilder sb = new StringBuilder(11);
		for (int i = 0; i < 11; i++)
			sb.append(NO.charAt(rnd.nextInt(NO.length())));
		return sb.toString();
	}

	NonRedundantPerson randomNonRedundantPerson() {
		return new NonRedundantPerson(Long.valueOf(randomId()),randomString(8), randomString(8));
	}
	
	Person randomPerson() {
		Person p = new Person();
		p.setId(randomId());
		p.setDateOfBirth(new Date(System.currentTimeMillis() - rnd.nextLong()));
		p.setForename(randomString(8));
		p.setSurname(randomString(8));
		return p;
	}

}
