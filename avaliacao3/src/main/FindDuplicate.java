package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicate {
    public FindDuplicate() {

    }

    public List<List<DirOrFile>> findDuplicate(List<DirOrFile> dirfiles) {
        List<List<DirOrFile>> result = new ArrayList<>();

        List<DirOrFile> onlyFiles = findFiles(dirfiles);

        for (int i=0; i < onlyFiles.size()-1; i++) {
            for (int j=i+1; j < onlyFiles.size(); j++) {
                if (onlyFiles.get(i).getContent() == onlyFiles.get(j).getContent()) {
                    List<DirOrFile> duplicatedFiles = new ArrayList<>();
                    duplicatedFiles.add(onlyFiles.get(i));
                    duplicatedFiles.add(onlyFiles.get(j));
                    result.add(duplicatedFiles);
                }
            }
        }

        return result;
    }

    private List<DirOrFile> findFiles(List<DirOrFile> dirfiles) {
        List<DirOrFile> result = new ArrayList<>();

        for (int i=0; i < dirfiles.size(); i++) {
            if (dirfiles.get(i).getContent() != null) { // is a file
                result.add(dirfiles.get(i));
            } else { // is a folder
                List<DirOrFile> resultFolder = findFiles(dirfiles.get(i).getMyFiles());
                result = Stream.concat(result.stream(), resultFolder.stream())
                        .collect(Collectors.toList());
            }
        }

        return result;
    }
}
