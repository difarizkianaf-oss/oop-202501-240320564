package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Receiptable;

public class Cash extends Pembayaran implements Receiptable {
    private double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    @Override
    public double biaya() {
        return 0.0;
    }

    @Override
    public boolean prosesPembayaran() {
        return tunai >= totalBayar(); // sederhana: cukup uang tunai
    }

    @Override
    public String cetakStruk() {
        return "    STRUCK PEMBAYARAN CASH   \n" +
                "------------------------------\n" +
                String.format(
                    "INVOICE    : %s %n" +
                    "TOTAL      : Rp %.2f %n" +
                    "BAYAR CASH : Rp %.2f %n" +
                    "KEMBALI    : Rp %.2f %n",
                        invoiceNo, totalBayar(), tunai, Math.max(0, tunai - totalBayar()));
    }
}