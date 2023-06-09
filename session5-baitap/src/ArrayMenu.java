import java.util.ArrayList;
import java.util.Scanner;

public class ArrayMenu {
    private static int[] array1 = {1, 2, 3, 4, 5};
    private static int[] array2 = {6, 7, 8, 9, 10};
    private static int[] array3 = {11, 12, 13, 14, 15};
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Hiển thị 3 mảng số nguyên");
            System.out.println("2. Hiển thị mảng được gộp từ 2 mảng số nguyên");
            System.out.println("3. Hiển thị mảng được gộp từ 3 mảng số nguyên");
            System.out.println("4. Chọn 1 mảng số nguyên để in ra");
            System.out.println("5. Dừng chương trình");
            System.out.println("==============");

            System.out.print("Chọn một lựa chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayArrays();
                    break;
                case 2:
                    mergeTwoArrays();
                    break;
                case 3:
                    mergeThreeArrays();
                    break;
                case 4:
                    selectArrayAndModify();
                    break;
                case 5:
                    System.out.println("Đã dừng chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void displayArrays() {
        System.out.println("Mảng 1: " + arrayToString(array1));
        System.out.println("Mảng 2: " + arrayToString(array2));
        System.out.println("Mảng 3: " + arrayToString(array3));
    }

    private static void mergeTwoArrays() {
        System.out.print("Chọn 1 - để gộp mảng 1 với2 \n chọn 2 - để gộp mảng 2 với 3 \n chọn 3 - để gộp mảng 3 với 1 (1/2/3): ");
        int choice = scanner.nextInt();

        int[] mergedArray;
        if (choice == 1) {
            mergedArray = mergeArrays(array1, array2);
        } else if (choice == 2) {
            mergedArray = mergeArrays(array2, array3);
        } else if (choice == 3) {
            mergedArray = mergeArrays(array3, array1);
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }

        System.out.println("Mảng được gộp: " + arrayToString(mergedArray));
    }

    private static void mergeThreeArrays() {
        int[] mergedArray = mergeArrays(mergeArrays(array1, array2), array3);
        System.out.println("Mảng được gộp: " + arrayToString(mergedArray));
    }

    private static void selectArrayAndModify() {
        System.out.print("Chọn một mảng (1/2/3): ");
        int arrayChoice = scanner.nextInt();

        int[] selectedArray;
        switch (arrayChoice) {
            case 1:
                selectedArray = array1;
                break;
            case 2:
                selectedArray = array2;
                break;
            case 3:
                selectedArray = array3;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }

        System.out.println("Mảng đã chọn: " + arrayToString(selectedArray));
        System.out.println("1. Thêm một phần tử vào cuối mảng");
        System.out.println("2. Thêm một phần tử vào đầu mảng");
        System.out.println("3. Xóa một phần tử ở vị trí được chọn");
        System.out.print("Chọn một lựa chọn: ");
        int operationChoice = scanner.nextInt();

        switch (operationChoice) {
            case 1:
                System.out.print("Nhập giá trị phần tử: ");
                int elementToAdd = scanner.nextInt();
                selectedArray = addElementToArray(selectedArray, elementToAdd);
                System.out.println("Mảng sau khi thêm: " + arrayToString(selectedArray));
                break;
            case 2:
                System.out.print("Nhập giá trị phần tử: ");
                int elementToAddToFront = scanner.nextInt();
                selectedArray = addElementToFront(selectedArray, elementToAddToFront);
                System.out.println("Mảng sau khi thêm: " + arrayToString(selectedArray));
                break;
            case 3:
                System.out.print("Nhập vị trí phần tử cần xóa: ");
                int indexToRemove = scanner.nextInt();
                if (indexToRemove >= 0 && indexToRemove < selectedArray.length) {
                    selectedArray = removeElementAtIndex(selectedArray, indexToRemove - 1);
                    System.out.println("Mảng sau khi xóa: " + arrayToString(selectedArray));
                } else {
                    System.out.println("Vị trí không hợp lệ.");
                }
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }

        // Cập nhật mảng được chọn
        switch (arrayChoice) {
            case 1:
                array1 = selectedArray;
                break;
            case 2:
                array2 = selectedArray;
                break;
            case 3:
                array3 = selectedArray;
                break;
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        return mergedArray;
    }

    private static int[] addElementToArray(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

    private static int[] addElementToFront(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        newArray[0] = element;
        System.arraycopy(array, 0, newArray, 1, array.length);
        return newArray;
    }

    private static int[] removeElementAtIndex(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }
}
