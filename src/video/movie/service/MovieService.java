package video.movie.service;

import video.common.AppService;
import video.common.Condition;
import video.movie.domain.Movie;
import video.movie.repository.MovieRepository;

import java.sql.SQLOutput;
import java.util.List;

import static video.ui.AppUi.*;

public class MovieService implements AppService {

    private final MovieRepository movieRepository = new MovieRepository();


    @Override
    public void start() {

        while (true) {
            movieManagementScreen();
            int selection = inputInteger(">>> ");

            switch (selection) {
                case 1:
                    insertMovieData();
                    break;
                case 2:
                    showSearchMovieData();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("### 메뉴를 다시 입력하세요.");
            }
        }
    }

    private void insertMovieData() {
        System.out.println("\n ====== 영화 DVD 정보를 추가합니다. ======");
        String movieName = inputString("# 영화명: ");
        String nation = inputString("# 국가명: ");
        int pubYear = inputInteger("# 발매년도: ");

        Movie newMovie = new Movie(movieName, nation, pubYear);

        movieRepository.addMovie(newMovie);
        System.out.printf("\n### [%s] 정보가 정상적으로 추가되었습니다.", movieName);

    }

    // 영화 검색 정보 출력
    private void showSearchMovieData() {

        try {
        List<Movie> movies = searchMovieData();
            int count = movies.size();
            if (count > 0) {
                System.out.printf("\n========================= 검색 결과(총 %d건) =========================\n", count);
                for (Movie movie : movies) {
                    System.out.println(movie);
                }
            } else {
                System.out.println("\n### 검색 결과가 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("\n### 발행년도는 정수로만 입력하세요.");
        }
    }



    // 영화 검색 비즈니스 로직
    private List<Movie> searchMovieData() throws Exception {
        System.out.println("\n============== 영화 DVD 검색 조건을 선택하세요. ===============");
        System.out.println("[ 1. 제목검색 | 2. 국가검색 | 3. 발매연도검색 | 4. 전체검색 ]");
        int selection = inputInteger(">>> ");

        Condition condition = Condition.ALL;

        switch (selection) {
            case 1:
                System.out.println("\n## 제목으로 검색합니다.");
                condition = Condition.TITLE;
                break;
            case 2:
                System.out.println("\n## 국가명으로 검색합니다.");
                condition = Condition.NATION;
                break;
            case 3:
                System.out.println("\n## 발매년도로 검색합니다.");
                condition = Condition.PUB_YEAR;
                break;
            case 4:
                System.out.println("\n## 전체 정보를 검색합니다.");
                break;
            default:
                System.out.println("\n### 해당 메뉴가 존재하지 않습니다. 전체 정보로 검색합니다.");
        }

        String keyword = "";
        if (condition != Condition.ALL) {
            keyword =inputString("# 검색어: ");
        }

        return movieRepository.searchMovieList(condition, keyword);


    }
}











