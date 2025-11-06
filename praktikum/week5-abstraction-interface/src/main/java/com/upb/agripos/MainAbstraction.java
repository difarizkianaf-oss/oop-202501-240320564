package com.upb.agripos;

import com.upb.agripos.model.kontrak.*;
import com.upb.agripos.model.pembayaran.*;
import com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("INV-001", 245000, 300000);
        Pembayaran ew = new EWallet("INV-002", 127000, "difa@ewallet", "123456");
        Pembayaran tf = new TransferBank("INV-003", 412000, "Bank DF", "12345678");

        System.out.println("===== INVOICE PEMBAYARAN =====");
        System.out.println("------------------------------");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println("------------------------------");
        System.out.println(((Receiptable) ew).cetakStruk());
        System.out.println("------------------------------");
        System.out.println(((Receiptable) tf).cetakStruk());

    CreditBy.print("Difa Rizkiana Fauziyah", "240320564");
    }
}