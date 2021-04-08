import java.util.Scanner;

class Exam{
    public static Scanner Input = new Scanner(System.in);
    
	public static int[][] Matrix(int[][] matrix){
        final int length_of_matrix= matrix.length;
        int upper_sum = 0, down_sum = 0, temp;
        for (int line = 0; line<length_of_matrix; line++){
            for (int column = 0; column<length_of_matrix; column++){
                if (line<column){
                    upper_sum += matrix[line][column];
                }
                else if (line>column){
                    down_sum += matrix[line][column];
                }
            }
        }
        if(upper_sum<down_sum){
            for (int line = 0; line<length_of_matrix; line++){
                for (int column = 0; column<length_of_matrix; column++){
                    if (line>column){
                        temp = matrix[line][column];
                        matrix[line][column] = matrix[length_of_matrix - line - 1][length_of_matrix - column - 1];
                        matrix[length_of_matrix - line - 1][length_of_matrix - column - 1] = temp;
                    }
                }
            }
        }
        return matrix;
    }
	
    public static String MatrixToString(int[][] matrix){
        String string = "";
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                string += matrix[i][j] + "\t";
            }
            string += "\n";
        }
        return string;
    }
	
    public static void main(String[] args){
        System.out.println("whats the length of the matrix?");
        int length = Input.nextInt();
        System.out.println("start filling it then");
        int[][] matrix = new int[length][length];
        for (int i = 0; i<length ; i++){
            for (int j = 0; j<length ; j++){
                matrix[i][j] = Input.nextInt();
            }
        }
        System.out.println(MatrixToString(Matrix(matrix)));
    }
}