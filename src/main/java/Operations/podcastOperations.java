package Operations;

import hellomaven.entities.podcast;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class podcastOperations
{
    public List<podcast> searchbyCreatDate(List<podcast> allPodCastlist, String date) {

        List<podcast> sa = new ArrayList<>();

        Optional filter = allPodCastlist.stream().filter(p -> p.getReleaseDate().equalsIgnoreCase(date)).findAny();

        if (filter.isPresent()) {

            sa = allPodCastlist.stream().filter(p -> p.getReleaseDate().equalsIgnoreCase(date)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("No such podCast is present");
        }
        return sa;
    }
    public List<podcast> searchbygenre(List<podcast> allPodCastlist, String genre) {

        List<podcast> sa = new ArrayList<>();

        Optional filter = allPodCastlist.stream().filter(p -> p.getPodcastGenre().equalsIgnoreCase(genre)).findAny();

        if (filter.isPresent()) {

            sa = allPodCastlist.stream().filter(p -> p.getPodcastGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("No such genre is present");
        }
        return sa;
    }

    public void display(List<podcast> allPodCastList) {

        Consumer<podcast> dis= d->System.out.println(d);

        allPodCastList.stream().forEach(dis);
    }
}
