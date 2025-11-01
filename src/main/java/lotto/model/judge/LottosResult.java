package lotto.model.judge;

import java.util.ArrayList;
import java.util.List;

public class LottosResult {
    private List<ResultRow> rows;
    private double roi;

    public LottosResult(){
        rows = new ArrayList<>();
        roi = 0.0;
    }

    public void addRow(String condition, Integer winnings, Integer count){
        rows.add(new ResultRow(condition, winnings, count));
    }

    public void setRoi(double roi){
        this.roi = roi;
    }

    static class ResultRow{
        private String condition;
        private Integer winnings;
        private Integer count;

        public ResultRow(String condition, Integer winnings, Integer count) {
            this.condition = condition;
            this.winnings = winnings;
            this.count = count;
        }

        public String getCondition() {
            return condition;
        }

        public Integer getWinnings() {
            return winnings;
        }

        public Integer getCount() {
            return count;
        }
    }

    public List<ResultRow> getRows() {
        return rows;
    }

    public double getRoi() {
        return roi;
    }
}
