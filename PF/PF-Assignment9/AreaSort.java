import java.util.ArrayList;

class AreaSort implements Sort{
	
	/**
	 * sort shape list according to area 
	 * @return sorted shape list
	 */
	public ArrayList<Shape> executeSort(ArrayList<Shape> shapeList){
		Shape temp;
		for (int i = 0; i < shapeList.size() - 1; i++) {
			for (int j = 0; j < shapeList.size() - i - 1; j++) {
				if (shapeList.get(j).getArea() < shapeList.get(j + 1).getArea()) {
					temp = shapeList.get(j);
					shapeList.set(j, shapeList.get(j + 1));
					shapeList.set(j + 1, temp);
				}
			}
		}
		return shapeList;
	}
}