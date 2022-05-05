package test;

import static org.junit.jupiter.api.Assertions.*;

import main.FindDuplicate;
import main.DirOrFile;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateTest {
    public static FindDuplicate FD;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.print("Configurando os testes ... ");

        FD = new FindDuplicate();

        System.out.println("OK");
    }

    @Test
    @Order(1)
    void testEmptyList () {
        try {
            List<DirOrFile> dirfiles = new ArrayList<>();
            List<List<DirOrFile>> duplicatedFiles = FD.findDuplicate(dirfiles);
            assertEquals(true, duplicatedFiles.isEmpty());
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @Test
    @Order(2)
    void testOneFileEmpty () {
        try {
            DirOrFile fileEmpty = new DirOrFile("ImEmpty.txt", "");

            List<DirOrFile> dirfiles = new ArrayList<>();
            dirfiles.add(fileEmpty);
            List<List<DirOrFile>> duplicatedFiles = FD.findDuplicate(dirfiles);
            assertEquals(true, duplicatedFiles.isEmpty());
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @Test
    @Order(3)
    void testOneSubDirEmpty () {
        try {
            List<DirOrFile> myFiles = new ArrayList<>();
            DirOrFile subDirEmpty = new DirOrFile("souPasta", myFiles);

            List<DirOrFile> dirfiles = new ArrayList<>();
            dirfiles.add(subDirEmpty);
            List<List<DirOrFile>> duplicatedFiles = FD.findDuplicate(dirfiles);
            assertEquals(true, duplicatedFiles.isEmpty());
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @Test
    @Order(4)
    void testOneSubDirWithOneFileEmpty () {
        try {
            DirOrFile fileEmpty = new DirOrFile("ImEmpty.txt", "");
            List<DirOrFile> myFiles = new ArrayList<>();
            myFiles.add(fileEmpty);
            DirOrFile subDirEmpty = new DirOrFile("souPasta", myFiles);

            List<DirOrFile> dirFiles = new ArrayList<>();
            dirFiles.add(subDirEmpty);
            List<List<DirOrFile>> duplicatedFiles = FD.findDuplicate(dirFiles);
            assertEquals(true, duplicatedFiles.isEmpty());
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @Test
    @Order(5)
    void testTwoEmptyFiles () {
        try {
            DirOrFile fileEmptyA = new DirOrFile("ImEmptyA.txt", "");
            DirOrFile fileEmptyB = new DirOrFile("ImEmptyB.txt", "");

            List<DirOrFile> dirFiles = new ArrayList<>();
            dirFiles.add(fileEmptyA);
            dirFiles.add(fileEmptyB);
            List<List<DirOrFile>> duplicatedFiles = FD.findDuplicate(dirFiles);
            List<List<DirOrFile>> correctResult = new ArrayList<>();
            correctResult.add(dirFiles);
            assertEquals(correctResult, duplicatedFiles);
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @Test
    @Order(6)
    void testTwoDifFiles () {
        try {
            DirOrFile fileEmpty = new DirOrFile("ImEmpty.txt", "");
            DirOrFile fileNotEmpty = new DirOrFile("ImNotEmpty.txt", "123");

            List<DirOrFile> dirFiles = new ArrayList<>();
            dirFiles.add(fileEmpty);
            dirFiles.add(fileNotEmpty);
            List<List<DirOrFile>> duplicatedFiles = FD.findDuplicate(dirFiles);
            assertEquals(true, duplicatedFiles.isEmpty());
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @Test
    @Order(7)
    void testSubDirAndFileEmpties () {
        try {
            List<DirOrFile> myFiles = new ArrayList<>();
            DirOrFile subDirEmpty = new DirOrFile("souPasta", myFiles);

            DirOrFile fileEmpty = new DirOrFile("ImEmpty.txt", "");

            List<DirOrFile> dirFiles = new ArrayList<>();
            dirFiles.add(fileEmpty);
            dirFiles.add(subDirEmpty);
            List<List<DirOrFile>> duplicatedFiles = FD.findDuplicate(dirFiles);
            assertEquals(true, duplicatedFiles.isEmpty());
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @Test
    @Order(8)
    void testSubDirWithTwoEmptyFiles () {
        try {
            List<DirOrFile> myFiles = new ArrayList<>();

            DirOrFile fileEmptyA = new DirOrFile("ImEmptyA.txt", "");
            DirOrFile fileEmptyB = new DirOrFile("ImEmptyB.txt", "");

            myFiles.add(fileEmptyA);
            myFiles.add(fileEmptyB);

            DirOrFile subDirEmpty = new DirOrFile("souPasta", myFiles);

            List<DirOrFile> dirFiles = new ArrayList<>();
            dirFiles.add(subDirEmpty);
            List<List<DirOrFile>> duplicatedFiles = FD.findDuplicate(dirFiles);

            List<List<DirOrFile>> correctResult = new ArrayList<>();
            correctResult.add(myFiles);
            assertEquals(correctResult, duplicatedFiles);
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @Test
    @Order(9)
    void testTheeSubDirsWithFileEmpties () {
        try {
            DirOrFile fileEmptyA = new DirOrFile("ImEmptyA.txt", "");
            List<DirOrFile> myFilesA = new ArrayList<>();
            myFilesA.add(fileEmptyA);
            DirOrFile subDirEmptyA = new DirOrFile("souPastaA", myFilesA);

            DirOrFile fileEmptyB = new DirOrFile("ImEmptyB.txt", "");
            List<DirOrFile> myFilesB = new ArrayList<>();
            myFilesA.add(fileEmptyB);
            DirOrFile subDirEmptyB = new DirOrFile("souPastaB", myFilesB);

            DirOrFile fileEmptyC = new DirOrFile("ImEmptyC.txt", "");
            List<DirOrFile> myFilesC = new ArrayList<>();
            myFilesA.add(fileEmptyC);
            DirOrFile subDirEmptyC = new DirOrFile("souPastaC", myFilesC);

            List<DirOrFile> dirFiles = new ArrayList<>();
            dirFiles.add(subDirEmptyA);
            dirFiles.add(subDirEmptyB);
            dirFiles.add(subDirEmptyC);
            List<List<DirOrFile>> duplicatedFiles = FD.findDuplicate(dirFiles);

            List<List<DirOrFile>> correctResult = new ArrayList<>();
            List<DirOrFile> RA = new ArrayList<>();
            RA.add(fileEmptyA);
            RA.add(fileEmptyB);
            correctResult.add(RA);
            List<DirOrFile> RB = new ArrayList<>();
            RB.add(fileEmptyA);
            RB.add(fileEmptyC);
            correctResult.add(RB);
            List<DirOrFile> RC = new ArrayList<>();
            RC.add(fileEmptyB);
            RC.add(fileEmptyC);
            correctResult.add(RC);
            assertEquals(correctResult, duplicatedFiles);
        } catch (Exception e) {
            System.out.println("");
        }
    }
}
