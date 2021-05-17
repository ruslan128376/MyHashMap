import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Random;

public class test002 {
	//final int  ELEMENTS=1000;


	public static void main(String[] args) {
		long t=System.nanoTime();
		long dt=0;


		test0StandartHashMap();
		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("test1StandartHashMap() time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));
		System.out.println("");

		test0MyHashMap();
		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("test1MyHashMap() Total time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));
		System.out.println("");

		test1StandartHashMap();
		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("test1StandartHashMap() Total time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));
		System.out.println("");

		test1MyHashMap();
		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("test1MyHashMap() Total time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));
		System.out.println("");

		test2StandartHashMap();
		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("test2StandartHashMap() Total time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));
		System.out.println("");

		test2MyHashMap();
		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("test2StandartHashMap() Total time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));
		System.out.println("");


	}

	//-----------------------------------------------------------
	public static void test0MyHashMap() {
		//with keys (0-999 999) plus (500 000 - 1 500 000)
		long s=0;
		long t=0;
		long dt=0;
		Random rnd = new Random();
		MyHashMap map = new MyHashMap();

		System.out.println("----------MY HASH MAP TEST(with sequential keys )------------");
		t = System.nanoTime();

		for(int i=0;i<1000000;i++) { // write 
			//Integer k = rnd.nextInt();
			//Long v= rnd.nextLong();
			Integer k = i;
			Long v= (long)i+1000000000;
			map.put(k, v);
		}

		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("put first part. Time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));

		for(int i=500000;i<1500000;i++) {
			//Integer k = rnd.nextInt();
			//Long v= rnd.nextLong();
			Integer k = i;
			Long v= (long)i+2000000000;
			map.put(k, v);
		}
		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("put second part. Time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));


		System.out.println("map size:"+ map.size());
		System.out.println("arraySize:"+ map.arraySize());

		for (Integer key : map.getKeys()) { // read all values
			
			s+=map.get(key);
		}
		System.out.println("sum:"+ s);

		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("read all the data time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));



		//return t;
	}	
	//-----------------------------------------------------------
	public static void test0StandartHashMap() {
		//with keys (0-999 999) plus (500 000 - 1 500 000)
		long startTime = System.nanoTime();
		long s=0;
		Random rnd = new Random();
		HashMap<Integer,Long> map = new HashMap<>();

		System.out.println("----------STANDART HASH MAP TEST(with sequential keys) ------------");

		for(int i=0;i<1000000;i++) { // write 
			//Integer k = rnd.nextInt();
			//Long v= rnd.nextLong();
			Integer k = i;
			Long v= (long)i+1000000000;
			map.put(k, v);
		}
		
		for(int i=500000;i<1500000;i++) {
			//Integer k = rnd.nextInt();
			//Long v= rnd.nextLong();
			Integer k = i;
			Long v= (long)i+2000000000;
			map.put(k, v);
		}

		System.out.println("map size:"+ map.size());
		//

		for (int key : map.keySet()) { // read all values
			//System.out.println("key:"+key+"   value:"+map.get(key));
			s+=map.get(key);
		}
		System.out.println("sum:"+ s);

		long estimatedTime = System.nanoTime() - startTime;
		//return estimatedTime;
	}


	//-----------------------------------------------------------
	public static void test1MyHashMap() {
		//with random 1 000 000 keys
		long s=0;
		long t=0;
		long dt=0;
		Random rnd = new Random();
		MyHashMap map = new MyHashMap();

		System.out.println("----------MY HASH MAP TEST(with random keys) ------------");
		t = System.nanoTime();

		for(int i=0;i<1000000;i++) { // write 
			Integer k = rnd.nextInt();
			Long v= rnd.nextLong();
			//Integer k = i;
			//Long v= (long)i+1000000000;
			map.put(k, v);
		}

		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("put .Time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));
		
		System.out.println("map size:"+ map.size());
		System.out.println("arraySize:"+ map.arraySize());

		for (Integer key : map.getKeys()) { // read all values
			//System.out.println("key:"+key+"   value:"+map.get(key));
			s+=map.get(key);
		}
		System.out.println("sum:"+ s);

		dt=System.nanoTime()-t;
		t = System.nanoTime() ;
		System.out.print("read all the data time: ");
		System.out.println(new DecimalFormat( "###,###.##" ).format(dt));


	}	
	//-----------------------------------------------------------
	public static void test1StandartHashMap() {
		//with random 1 000 000 keys
		long startTime = System.nanoTime();
		long s=0;
		Random rnd = new Random();
		HashMap<Integer,Long> map = new HashMap<>();

		System.out.println("----------STANDART HASH MAP TEST (with random keys )------------");

		for(int i=0;i<1000000;i++) { // write 
			Integer k = rnd.nextInt();
			Long v= rnd.nextLong();
			//Integer k = i;
			//Long v= (long)i+1000000000;
			map.put(k, v);
		}
			System.out.println("map size:"+ map.size());
		//

		for (int key : map.keySet()) { // read all values
			s+=map.get(key);
		}
		System.out.println("sum:"+ s);

		
	}



	//-----------------------------------------------------------
	public static void test2StandartHashMap() {
		// small test
		//long startTime = System.nanoTime();
		long s=0;
		Random rnd = new Random();
		HashMap<Integer,Long> map = new HashMap<>();

		System.out.println("----------STANDART HASH MAP TEST (SMALL)------------");

		for(int i=0;i<10;i++) { // write first part 
			Integer k = i;
			Long v= (long)i+1000;
			map.put(k, v);
		} 

		for(int i=8;i<18;i++) {//  write second part
			Integer k = i;
			Long v= (long)i+2000;
			map.put(k, v);
		}
		map.put(-1, 777L); //  add single key

		System.out.println("map size:"+ map.size());

		System.out.println("key: -3(wrong)"+"   value:"+map.get(-3)); 

		for (int key : map.keySet()) { // read all values
			System.out.println("key:"+key+"   value:"+map.get(key));
			s+=map.get(key);
		}
		System.out.println("sum:"+ s);

		//long estimatedTime = System.nanoTime() - startTime;
		//return estimatedTime;
	}


	//-----------------------------------------------------------
	public static long test2MyHashMap() {
		// small test
		long startTime = System.nanoTime();
		long s=0;
		Random rnd = new Random();
		MyHashMap map = new MyHashMap();

		System.out.println("----------MY HASH MAP TEST (SMALL)------------");

		for(int i=0;i<10;i++) { // write 
			Integer k = i;
			Long v= (long)i+1000;
			map.put(k, v);
		} 

		for(int i=8;i<18;i++) {
			Integer k = i;
			Long v= (long)i+2000;
			map.put(k, v);
		}
		map.put(-1, 777L);

		System.out.println("map size:"+ map.size());
		System.out.println("arraySize:"+ map.arraySize());


		System.out.println("key: -3(wrong)"+"   value:"+map.get(-3));

		for (int key : map.getKeys()) { // read all values
			System.out.println("key:"+key+"   value:"+map.get(key));
			s+=map.get(key);
		}
		System.out.println("sum:"+ s);

		long estimatedTime = System.nanoTime() - startTime;
		return estimatedTime;
	}



}
