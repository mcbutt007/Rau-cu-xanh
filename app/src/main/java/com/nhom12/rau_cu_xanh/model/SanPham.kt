package com.nhom12.rau_cu_xanh.model

class SanPham {
    private val ID = 0
    private val Num = 0
    private val Name: String? = null
    private val price : Double? = null
    private val KLT: Double? = null
    private val DonVi: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SanPham

        if (ID != other.ID) return false
        if (Num != other.Num) return false
        if (Name != other.Name) return false
        if (price != other.price) return false
        if (KLT != other.KLT) return false
        if (DonVi != other.DonVi) return false

        return true
    }

    override fun hashCode(): Int {
        var result = ID
        result = 31 * result + Num
        result = 31 * result + (Name?.hashCode() ?: 0)
        result = 31 * result + (price?.hashCode() ?: 0)
        result = 31 * result + (KLT?.hashCode() ?: 0)
        result = 31 * result + (DonVi?.hashCode() ?: 0)
        return result
    }


}