
extension JavaUtilArrayList {
    
    func toNSArray<T>() -> [T] {
        var arr:[T] = []
        for i:Int32 in 0 ..< self.size() {
            arr.append(self.getWith(i) as! T)
        }
        return arr
    }
    
}
