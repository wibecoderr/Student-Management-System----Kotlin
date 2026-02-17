import java.util.Scanner

data class Subject(
    var subjectName: String,
    var marks: Int
)

data class Student(
    var rollNo: Int,
    var firstName: String,
    var studentClass: Int,
    var subjects: MutableList<Subject>
){
    fun TotalMarks():Int{
      return subjects.sumOf { it.marks }
    }
}
/* Student Mangaement System Ideas :: Features You Should Implement
Add student -- done
Remove student -- done
Update marks -- done
Find topper -- done
Show students above certain marks -- done
Show all unique subjects (using Set)
Remove duplicate students Search student by id Count students per subject
 */
fun main() {

    val classObject = mutableListOf<Student>()
    val scanner = Scanner(System.`in`)

    while (true) {

        println("\n1. Add Student")
        println("2. Remove Student")
        println("3. Update Marks")
        println("4.  For finding Topper")
        println("5. Find Student above certain marks")

        println("Enter choice:")
        when (scanner.nextInt()) {

            1 -> {
                println("Enter Roll no:")
                val rollNo = scanner.nextInt()

                println("Enter name:")
                val name = scanner.next()

                println("Enter Class:")
                val className = scanner.nextInt()

                println("How many subjects?")
                val totalSub = scanner.nextInt()

                val subjectList = mutableListOf<Subject>()

                for (i in 1..totalSub) {
                    println("Enter subject name:")
                    val subName = scanner.next()

                    println("Enter marks:")
                    val marks = scanner.nextInt()

                    subjectList.add(Subject(subName, marks))
                }

                classObject.add(Student(rollNo, name, className, subjectList))
                println("Student Added Successfully")
            }

            2 -> {
                println("Enter roll no:")
                val rollNo = scanner.nextInt()

                val removed = classObject.removeIf { it.rollNo == rollNo }

                if (removed) {
                    println("Student Removed")
                } else {
                    println("Student Not Found")
                }
            }

            3 -> {
                println("Enter roll no:")
                val rollNo = scanner.nextInt()

                val student = classObject.find { it.rollNo == rollNo }

                if (student != null) {

                    println("Enter subject name:")
                    val subjectName = scanner.next()

                    val subject = student.subjects.find {
                        it.subjectName == subjectName
                    }

                    if (subject != null) {
                        println("Enter new marks:")
                        subject.marks = scanner.nextInt()
                        println("Marks Updated")
                    } else {
                        println("Subject not found")
                    }

                } else {
                    println("Student not found")
                }
            }
               4-> {
                   println("Finding Toppers \n")
                   val topper = classObject.maxByOrNull { it.TotalMarks()}
                   if (topper != null) {
                       println("Topper: $topper, Total Marks: ${topper.TotalMarks()}")

                   }else{
                       println("Toppers not found")
                   }
               }

        }
    }
}
