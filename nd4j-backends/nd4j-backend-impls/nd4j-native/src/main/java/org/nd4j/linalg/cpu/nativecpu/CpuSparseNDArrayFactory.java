package org.nd4j.linalg.cpu.nativecpu;

import org.bytedeco.javacpp.Pointer;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.complex.IComplexDouble;
import org.nd4j.linalg.api.complex.IComplexFloat;
import org.nd4j.linalg.api.complex.IComplexNDArray;
import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ndarray.ISparseNDArray;
import org.nd4j.linalg.cpu.nativecpu.blas.*;
import org.nd4j.linalg.factory.BaseNDArrayFactory;
import org.nd4j.linalg.factory.BaseSparseNDArrayFactory;
import org.nd4j.linalg.factory.Nd4j;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * @author Audrey Loeffel
 */
public class CpuSparseNDArrayFactory extends BaseSparseNDArrayFactory {

    public CpuSparseNDArrayFactory(){}

    static{
        Nd4j.getBlasWrapper();
    }
    // contructors ?

    @Override
    public void createBlas(){ blas = new SparseCpuBlas();}

    @Override
    public void createLevel1() {
        level1 = new SparseCpuLevel1();
    }

    @Override
    public void createLevel2() {
        level2 = new SparseCpuLevel2();
    }

    @Override
    public void createLevel3() { level3 = new SparseCpuLevel3(); }

    @Override
    public void createLapack() {
        lapack = new SparseCpuLapack();
    }

    @Override
    public ISparseNDArray createSparse(double[] data, int[] columns, int[] pointerB, int[] pointerE, int[] shape){
        return new SparseNDArrayCSR(data, columns, pointerB, pointerE, shape);
    }



}
