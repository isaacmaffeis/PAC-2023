package BST;

class Record{
	public Object data;   //dati satellite
	public Comparable key;//campo chiave
		
	public Record(){}
	
	public Record(Object d, Comparable k){
		data = d;
		key = k;
	}
	
	@Override
	public boolean equals(Object r) {
		if (this == r)
			return true;
		else if (r instanceof Record)
			return equals((Record)r);
		return false;
	}
	
	public boolean equals(Record r) {
		if (this.data.equals(r.data) && this.key.equals(r.key))
			return true;
		return false;
	}
	
	public Comparable getKey(){return key;}
	public Object getData(){return data;}
	public String toString(){return "(data:"+data+",key:"+key+") ";}
}