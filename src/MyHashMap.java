
public class MyHashMap {
	
	public float loadFactor;
	private long[] v; // values
	private int[] k; // keys
	private boolean[] f; // is free
	private int size;
	private int arraySize;
	
	public MyHashMap() {
		loadFactor = 0.5f;
		this.size=0;
		arraySize=16;
		v=new long[arraySize];
		k=new int[arraySize];
		f=new boolean[arraySize];
		for(int i=0;i<arraySize;i++) {f[i]=true;}
	}
	
	public MyHashMap(int size) {
		arraySize=size;
		loadFactor = 0.5f;
		this.size=0;
		v=new long[arraySize];
		k=new int[arraySize];
		f=new boolean[arraySize];
		for(int i=0;i<arraySize;i++) {
			f[i]=true;
		}
	}
	
	private void resize(int newSize) { 
		long startTime = System.nanoTime();
		
		MyHashMap map= new MyHashMap(newSize);
		for(int key:k) {
			map.put(key, this.get(key));
		}
		this.v=map.v;
		this.k=map.k;
		this.f=map.f;
		this.loadFactor=map.loadFactor;
		this.size=map.size;
		this.arraySize=map.arraySize;
		
		long estimatedTime = System.nanoTime() - startTime;
		
		//System.out.println("Resize time: "+estimatedTime);
		//System.out.println("New size: "+this.arraySize);
		
	}

	//--------------------------------------------------
	public Long put(Integer key, Long value) {
		if(size>0) {
			float lf=size/v.length;
			
			if(lf>loadFactor) {	resize(arraySize*2);}
		}
		
		for(int i=index(key);;i++) {
			if(i>=arraySize) i=0;
			if(f[i]==true) {
				k[i]=key;
				f[i]=false;
				size++;
			}
			if(k[i]==key) {
				v[i]=value;
				return value;
			}
			
		}
	}
	
	//--------------------------------------------------
	public Long get(Integer key) {
		for(int i=index(key);;i++) {
			if(i>=arraySize) i=0;
			if(f[i]==true) return null;//throw new RuntimeException("wrong key");//}
			if(k[i]==key) return v[i];
			
		}
	}
	//--------------------------------------------------
	
		public int size() {
			return this.size;
		}
		//--------------------------------------------------
		
		public int arraySize() {
			return this.arraySize;
		}
		//--------------------------------------------------
	
	public int[] getKeys(){
		int[] ar=new int[this.size];
		int p=0;
		
		for(int i=0;i<f.length;i++) {
			if(f[i]==false) {
				ar[p]=k[i];
				p++;
			}
		}
		return ar;
	}
	
	         
	int index(int key) {
		return Math.abs(Integer.hashCode(key)) % arraySize;
		//return Math.abs(Integer.hashCode(key>>15)^key) % arraySize;
	    
	}
	
	//--------------------------------------------------
	

}
