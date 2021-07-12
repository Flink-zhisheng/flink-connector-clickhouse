//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tiny.flink.connector.clickhouse.internal.partitioner;

import org.apache.flink.table.data.RowData;

/**
 * @author tiger
 */
public class BalancedPartitioner implements ClickHousePartitioner {

    private static final long serialVersionUID = 1L;

    private int nextShard = 0;

    public BalancedPartitioner() {
    }

    @Override
    public int select(RowData record, int numShards) {
        this.nextShard = (this.nextShard + 1) % numShards;
        return this.nextShard;
    }
}