class kthLargestELement{
	
	Comparable kthELement;

	public static Comparable getKthLargestElement (Comparable[] arr, int k) {

		int hi = arr.length - 1, lo = 0;
		while (hi > lo) {
			int j = partition(arr, lo, hi);
			if (j < k) lo = j + 1;
			else if (j > k) hi = j - 1;
			else return arr[k];
		}
		return arr[k];

	}

	public static int partition (Comparable[] arr, int lo, int hi) {
		int i = lo, j = hi + 1;
		while (true) {
			while (arr[++i].compareTo(arr[lo]) < 0)
				if (i == hi) break;
			while (arr[--j].compareTo(arr[lo]) > 0)
				if (j == lo) break;

			if (j <= i) break;
			exch (arr, i, j);
		}
		exch (arr, lo, j);
		return j;
	}

	public static void exch (Comparable[] arr, int a,int b) {
		Comparable temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		Integer[] arr = {new Integer(5), new Integer(2), new Integer(8), new Integer(100), new Integer(190), new Integer(50), new Integer(20), new Integer(1000), new Integer(99), new Integer(150)};
		Integer out = (Integer) getKthLargestElement (arr, 2);
		System.out.println(Integer.parseInt(out));
		System.out.println();
		ImprovedMergeSort.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Integer.parseInt(arr[i]));
		}
	}
}