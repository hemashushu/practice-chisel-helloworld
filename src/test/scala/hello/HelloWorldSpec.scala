package hello

import chisel3._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.flatspec.AnyFlatSpec

class HelloWorldSpec extends AnyFreeSpec with ChiselScalatestTester {

  "helloTest" in {
    test(new HelloWorld()) { dut =>
      dut.io.a.poke(1)
      dut.io.b.poke(1)
      dut.io.out.expect(1)
      dut.io.delay_a.expect(0)
      dut.clock.step()
      dut.io.out.expect(1)
      dut.io.delay_a.expect(1)

      dut.io.a.poke(2)
      dut.io.out.expect(0) // 2 AND 1
      dut.io.delay_a.expect(1)
      dut.clock.step()
      dut.io.out.expect(0) // 2 AND 1
      dut.io.delay_a.expect(2)

      dut.io.a.poke(1)
      dut.io.out.expect(1) // 1 AND 1
      dut.io.delay_a.expect(2)
      dut.clock.step()
      dut.io.out.expect(1) // 1 AND 1
      dut.io.delay_a.expect(1)
    }
  }
}

class HelloWorldWaveform extends AnyFlatSpec with ChiselScalatestTester {
  "HelloWorldWaveform" should "pass" in {
    test(new HelloWorld)
      .withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
        for (a <- 0 until 8) {
          for (b <- 0 until 8) {
            dut.io.a.poke(a.U)
            dut.io.b.poke(b.U)
            dut.clock.step()
          }
        }
      }
  }
}
