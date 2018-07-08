package LeetCode.Design;

public class HitCounter {

	int[] hitCounts = new int[300];
	int startIndex=1;
	int endInex=300;
	int thisSign=1;
	int currentTimeStamp=0;
	int totalHitCounts=0;
	public static void main(String[] args) {
		HitCounter hc=new HitCounter();
		hc.hit(2);
		hc.hit(3);
		hc.hit(4);
		System.out.println(hc.getHits(300));
		System.out.println(hc.getHits(301));
		System.out.println(hc.getHits(302));
		System.out.println(hc.getHits(303));
		System.out.println(hc.getHits(304));
		hc.hit(501);
		System.out.println(hc.getHits(1006));
	}

	public HitCounter() {
		for(int i=0;i<300;i++) {
			hitCounts[i]=0;
		}
	}

	public void hit(int timestamp) {
		int indexToSave = getIndexToSave(timestamp);

		if(indexToSave==0 && (timestamp>endInex+1)) {
			startIndex=endInex+2;
			if((startIndex/100)%2==0) {
				thisSign=1;
			}else {
				thisSign=-1;
			}
		}
		clearCellsBetween(currentTimeStamp, indexToSave);	
		if(hitCounts[indexToSave]!=0&&
				thisSign!=hitCounts[indexToSave]/Math.abs(hitCounts[indexToSave])) {
			totalHitCounts++;
			hitCounts[indexToSave]=thisSign*1;
		}else {
			totalHitCounts++;
			hitCounts[indexToSave]=thisSign*1+hitCounts[indexToSave];
		}
		currentTimeStamp=indexToSave;
		for(int i=0;i<hitCounts.length;i++)
			System.out.print(hitCounts[i]+" ");
		System.out.println();
	}

	private int getIndexToSave(int timestamp) {
		int count = 0;
		while(timestamp>endInex) {
			startIndex=endInex+1;
			endInex=startIndex+299;
			count++;
		}
		if(count>1) {
			totalHitCounts=0;
			for(int i=0;i<300;i++) {
				hitCounts[i]=0;
			}
		}
		timestamp= timestamp-startIndex;
		
		return timestamp;
	}

	/** Return the number of hits in the past 5 minutes.
		        @param timestamp - The current timestamp (in seconds granularity). */
	public int getHits(int timestamp) {

		int indexToSave = getIndexToSave(timestamp);
		clearCellsBetween(currentTimeStamp,indexToSave);
		currentTimeStamp=indexToSave;
		return totalHitCounts;

	}

	private void clearCellsBetween(int currentTimeStamp, int indexToSave){

		if(indexToSave>=currentTimeStamp) {
			for(int i= currentTimeStamp+1;i<=indexToSave;i++) {
				totalHitCounts-=hitCounts[i];
				hitCounts[i]=0;
			}
		}
		else {
			for(int i= currentTimeStamp+1;i<300;i++) {
				totalHitCounts-=hitCounts[i];
				hitCounts[i]=0;}
			for(int j= 0;j<=indexToSave;j++) {
				totalHitCounts-=hitCounts[j];
				hitCounts[j]=0;}

		}
	}
}

