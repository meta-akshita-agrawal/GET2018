import java.util.ArrayList;

class DistanceSort implements Sort{
	
	/**
	 * sort shape list according to origin distance
	 * @return sorted shape list
	 */
	public ArrayList<Shape> executeSort(ArrayList<Shape> shapeList){
		Shape temp;
		for (int i = 0; i < shapeList.size() - 1; i++) {
			for (int j = 0; j < shapeList.size() - i - 1; j++) {
				Point origin = shapeList.get(i).getOrigin();
				if (shapeList.get(j).originDistance(origin) < shapeList.get(j + 1).originDistance(origin)) {
					temp = shapeList.get(j);
					shapeList.set(j, shapeList.get(j + 1));
					shapeList.set(j + 1, temp);
				}
			}
		}
		return shapeList;
	}
}