package top.flygrk.ishare.springbootswagger.stream.practice;

import top.flygrk.ishare.springbootswagger.stream.entity.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package top.flygrk.ishare.springbootswagger.stream.practice
 * @Author wuzy@watone.com.cn
 * @Date 2019/8/6 10:34
 * @Version V1.0
 * @Description:
 */
public class ArtistPractice {

    public static void main(String[] args) {
        Artist artist1 = new Artist();
        artist1.setFrom("London");
        artist1.setName("zzz");
        Artist artist2 = new Artist();
        artist2.setFrom("London");
        artist2.setName("yyy");
        Artist artist3 = new Artist();
        artist3.setFrom("HK");
        artist3.setName("www");
        Artist artist4 = new Artist();
        artist4.setFrom("SH");
        artist4.setName("nnn");

        List<Artist> artistList = new ArrayList <>();
        artistList.add(artist1);
        artistList.add(artist2);
        artistList.add(artist3);
        artistList.add(artist4);



        int count = 0;
        for (Artist artist : artistList) {
            if (artist.isFrom("London")) {
                count ++;
            }
        }

        System.out.println("传统方式计数： " + count);


        System.out.println("-------------分割线---------------");

        long count2 = artistList.stream()
                .filter(artist -> artist.isFrom("London"))
                .count();
        System.out.println("stream方式计数： " + count2);

    }

}
