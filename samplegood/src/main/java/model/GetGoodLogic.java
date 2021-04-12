package model;

import dao.GoodsDAO;

public class GetGoodLogic {
	public Goods execute(Goods goods) {

        GoodsDAO dao = new GoodsDAO();
        Goods good = dao.select(goods.getArticle_id());
        return good;
    }
}
