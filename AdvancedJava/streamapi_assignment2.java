class tasks
{
    List<String> tasks4(List<Student> emp1) {
        return emp1.stream().filter(a->a.getCourse().equalsIgnoreCase("Data Science") && a.getMarks()>75 && a.getYearOfStudy()<3)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed().thenComparingInt(Student::getAge))
                .map(a->a.getName().toLowerCase())
                .toList();
    }
    List<String> tasks5(List<Student> emp1) {
        return emp1.stream().filter(a->a.getCity().charAt(0)=='M' && a.getMarks()>60 && a.getMarks()<90 && a.getAge()>20)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed().thenComparingInt(Student::getYearOfStudy))
                .map(a->String.valueOf(a.getId()))
                .toList();

    }

    List<String> tasks6(List<Student> emp1){
        return emp1.stream().filter(a->a.getCourse().length()>4 && a.getMarks()<65 && a.getYearOfStudy()==4)
                .sorted(Comparator.comparingInt(Student::getAge).reversed().thenComparing(Student::getCity))
                .map(a->new StringBuilder(a.getName())
                        .reverse()
                        .toString())
                .toList();
    }
