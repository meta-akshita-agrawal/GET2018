package jdbc;

//POJO CATEGORY
public class Category {

	String parentCategory;
	int childCount;
	
	Category(String parentCategory,int childCount){
		this.parentCategory = parentCategory;
		this.childCount = childCount;
	}
	
	
	public String getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}
	public int getChildCount() {
		return childCount;
	}
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
	
}
