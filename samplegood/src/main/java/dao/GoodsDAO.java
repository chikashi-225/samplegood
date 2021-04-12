package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Goods;


public class GoodsDAO {
	private final String url = "jdbc:postgresql://localhost:5432/Goods";
    private final String user = "postgres";
    private final String passWord = "test";

    /********************************************************************************
     * 「いいね」テーブルから記事IDを検索し、いいねを集計して検索結果を返します。
     ********************************************************************************/
    public Goods select(String article_id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Goods goods = new Goods();


        try {
             /* JDBCドライバの定義 */
             Class.forName("org.postgresql.Driver");

             /* PostgreSQLへの接続 */
             con = DriverManager.getConnection(url, user, passWord);

             /* SELECT文の準備 */
             String sql = "select article_id, count(*) ";
             sql += "from Goods ";
             sql += "group by article_id ";
             sql += "order by count(*) DESC; ";
             st = con.prepareStatement(sql);


             /* SELECT文の実行 */
             rs = st.executeQuery();
             goods.setUser_id(rs.getString("USER_ID"));
             goods.setArcticle_id(rs.getString("ARTICLE_ID"));
             goods.setGoodCnt(rs.getInt("GOOD"));


        } catch(Exception e) {
            System.out.println("DBアクセス時にエラーが発生しました。");
            e.printStackTrace();
        } finally {
             /* PostgreSQLとの接続を切断 */
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {}
            }

            if(st != null) {
                try {
                    st.close();
                } catch (SQLException e) {}
            }

            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {}
            }
        }

        return goods;
    }

    /********************************************************************************
     * 「いいね」テーブルにいいねを追加します
     ********************************************************************************/

    public int insert(Goods goods) {
        Connection con = null;
        PreparedStatement st = null;
        int rs = 0;//更新件数

        try {
             /* JDBCドライバの定義 */
             Class.forName("org.postgresql.Driver");

             /* PostgreSQLへの接続 */
             con = DriverManager.getConnection(url, user, passWord);

             /* INSERT文の準備 */
             String sql = "";
             sql = "INSERT INTO Goods(user_id, article_id) ";
             sql += "VALUES(?, ?);";

             st = con.prepareStatement(sql);
             st.setString(1, goods.getUser_id());
             st.setString(2, goods.getArticle_id());

             /* SELECT文の実行 */
             rs = st.executeUpdate();

        } catch(Exception e) {
            System.out.println("DBアクセス時にエラーが発生しました。");
            e.printStackTrace();
        } finally {
            /* PostgreSQLとの接続を切断 */
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException e) {}
            }

            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {}
            }
        }


        return rs;
    }
}
